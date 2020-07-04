import React from "react";
import "./EstiloEasyParts.css";
import { Parallax } from "react-parallax";
import Navbar from "../nav-bar/nav-bar";
import { SearchStore, UserStore } from "../../stores";
import { useHistory } from "react-router-dom";

const inlineStyle = {
  left: "50%",
  top: "50%",
  position: "absolute",
  padding: "20px",
  transform: "translate(-50%, -50%)",
  color: "#fff",
};

function EstiloEasyParts() {
  const history = useHistory();

  return (
    <div id="estiloeasyparts">
      <div className="izqEstiloEasyParts"></div>

      <div className="derEstiloEasyParts">
        <Parallax
          bgImage={require("../../assets/Parallax3.jpg")}
          strength={500}
        >
          <Navbar />
          <div style={{ height: "100vh" }}>
            <div style={inlineStyle}>
              <div
                style={{ textDecoration: "none" }}
                onClick={() => {
                  if (UserStore.pc.powerSource !== null) {
                    UserStore.pc2 = { ...UserStore.pc };
                    UserStore.quantities2 = { ...UserStore.quantities };
                    UserStore.clearPc();
                    SearchStore.typeSelected = "cpu";
                  }
                  history.push("/estiloEP");
                }}
              >
                <h1 style={{ fontSize: "50px", color: "white", cursor: "pointer"}}>
                  Estilo EasyParts
                </h1>
              </div>
            </div>
            <div className="textExperto">
              <div className="text">
                <h3>Si te sientes experto arma tu equipo a tu manera</h3>
              </div>
            </div>
          </div>
        </Parallax>
      </div>
    </div>
  );
}

export default EstiloEasyParts;
