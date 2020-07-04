import React from "react";
import "./nav-bar-internal.css";
import { useHistory } from "react-router-dom";
import HomeIcon from "@material-ui/icons/Home";
import AccountCircleIcon from "@material-ui/icons/AccountCircle";
import { UserStore } from "../../stores";
import { inject, observer } from "mobx-react";
import { closeSession } from "../nav-bar/nav-bar-logic";

const NavBarInternal = ({ userStore, route }) => {
  const history = useHistory();

  return (
    <div className="Head">
      <p className="Home" onClick={() => history.push("/")}>
        <HomeIcon className="HomeButton" />
        Inicio
      </p>
      <div
        className="AccountInfoHead"
        onClick={() => {
          if (!userStore.loggedIn) {
            userStore.routeOrigin = route;
            history.push("/login");
          }
        }}
      >
        {!UserStore.loggedIn ? (
          "Iniciar Sesión"
        ) : (
          <div className="dropdown">
            <div className="AccountInfoBaseHead">
              <AccountCircleIcon className="AccountInfoIconHead" />
              <p>{UserStore.email.split("@")[0]}</p>
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
};

export default inject("userStore")(observer(NavBarInternal));
