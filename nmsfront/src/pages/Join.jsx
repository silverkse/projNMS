import EnterMemInfo from "../components/join/Comp_EnterMemInfo";
import TermsAndConditions from "../components/join/Comp_TermsAndConditions";

function Join() {
  return(
    <div id="join" className="dFlex">
      <TermsAndConditions/>
      <EnterMemInfo/>
    </div>
  )
}

export default Join;