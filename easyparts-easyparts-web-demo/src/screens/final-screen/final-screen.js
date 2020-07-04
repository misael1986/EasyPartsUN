import React from "react";
import "./final-screen.css";
import { NavBarInternal, PcComplete } from "../../components";
import { UserStore } from "../../stores";

function FinalScreen() {
  return (
    <div className="screen">
      <NavBarInternal route="/final" />
      <div className="main">
        <div className="leftpanel">
          <h1>EasyParts</h1>
          <h3 className="TuComputador">
            Tu computador se armará con los siguientes componentes!
          </h3>
        </div>
        <div className="rightpanel">
          <PcComplete pc={UserStore.pc} />
        </div>
      </div>
    </div>
  );
}

export default FinalScreen;
