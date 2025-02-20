import axios from "axios";

const API_BASE_URL =
  "https://8dwh02mfuh.execute-api.ap-southeast-2.amazonaws.com/dev/"; // Spring Boot 서버 주소

export const fetchNews = async () => {
  try {
    const response = await axios.get(`${API_BASE_URL}/user`);
    console.log("API gateway랑 연결 성공");
    return response.data;
  } catch (error) {
    console.error("Error fetching news:", error);
    return [];
  }
};

const instance = axios.create({
  baseURL: API_BASE_URL,
  withCredentials: true,
});

// 요청 인터셉터
instance.interceptors.request.use(
  function (config) {
    const token = localStorage.getItem("accessToken");
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  function (error) {
    return Promise.reject(error);
  }
);

// 응답 인터셉터
instance.interceptors.response.use(
  function (response) {
    return response;
  },
  async function (error) {
    if (error.response && error.response.status === 401) {
      // 인증 오류 처리(ex. 로그아웃 처리)
      console.error("Unauthorized, logging out...");
      localStorage.removeItem("accessToken");
      window.location.href("/serviceConnection");
    }

    // accessToken 만료 시 새 토큰 요청청
    if (error.response && error.response.status === 600) {
      try {
        // 백에서 CORS 설정을하면 withCredentials는 instance에만 적용해도 됨됨
        const res = await instance.post(
          "http://localhost:8082/auth/refresh",
          {},
          { withCredentials: true }
        );

        // 새 accessToken 저장
        localStorage.setItem("accessToken", res.data.accessToken);

        // 기존 요청을 새 토큰으로 다시 시도(config를 복사하여 사용용)
        const newRequest = { ...error.config };
        newRequest.config.headers.Authorization = `Bearer ${res.data.accessToken}`;
        return instance(newRequest);
      } catch {
        console.error("Failed to refresh token, logging out...");
        localStorage.removeItem("accessToken");
        window.location.href("/serviceConnection");
      }
    }
    return Promise.reject(error);
  }
);

export default instance;
