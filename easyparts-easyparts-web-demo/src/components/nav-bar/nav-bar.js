import React from "react";
import "./nav-bar.css";
import { Link } from "react-scroll";
import { useHistory } from "react-router-dom";
import AccountCircleIcon from "@material-ui/icons/AccountCircle";
import { inject, observer } from "mobx-react";
import { closeSession } from "./nav-bar-logic";

function NavBar({ userStore }) {
  const history = useHistory();

  return (
    <div className="navbar">
      <ul className="nav-items">
        <li className="nav-item">
          <Link
            activeClass="active"
            to="inicio"
            spy={true}
            smooth={true}
            offset={0}
            duration={500}
          >
            Inicio
          </Link>
        </li>
        <li className="nav-item">
          <Link
            activeClass="active"
            to="proposito"
            spy={true}
            smooth={true}
            offset={0}
            duration={500}
          >
            Propósito
          </Link>
        </li>
        <li className="nav-item">
          <Link
            activeClass="active"
            to="estiloeasyparts"
            spy={true}
            smooth={true}
            offset={0}
            duration={500}
          >
            Estilo EasyParts
          </Link>
        </li>
      </ul>
      <div
        className="AccountInfo"
        onClick={() => {
          if (!userStore.loggedIn) {
            userStore.routeOrigin = "/";
            history.push("/login");
          }
        }}
      >
        {!userStore.loggedIn ? (
          <p className="AccountInfoText">Iniciar Sesión</p>
        ) : (
          <div className="dropdown">
            <div className="AccountInfoBase">
              <AccountCircleIcon className="AccountInfoIcon" />
              <p className="AccountInfoText">{userStore.email.split("@")[0]}</p>
              <p className="flecha"> ▼</p>
            </div>
            <div className="dropdown-content">
              <p
                className="labelCerrarSesion"
                onClick={(event) => {
                  closeSession(userStore, history);
                  event.stopPropagation();
                }}
              >
                Cerrar Sesión
              </p>
            </div>
          </div>
        )}
      </div>
    </div>
  );
}

export default inject("userStore")(observer(NavBar));
