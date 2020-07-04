import React, { useEffect } from "react";
import "./purpose-list-screen.css";
import { choosePc, getTowersWithPurpose } from "./purpose-list-screen-logic";
import { inject, observer } from "mobx-react";
import { ListItemTower, NavBarInternal } from "../../components";
import { useHistory } from "react-router-dom";
import { UserStore } from "../../stores";

function PurposeListScreen({ purposeStore }) {
  const history = useHistory();

  useEffect(() => {
    UserStore.pc2 = { ...UserStore.pc };
    UserStore.quantities2 = { ...UserStore.quantities };
    getTowersWithPurpose();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  return (
    <div className="PurposeListMain">
      <NavBarInternal route="/purposeList" />
      <p className="TopHeader">
        Estos son nuestros computadores recomendados para {purposeStore.name}:
      </p>
      <div className="ListTower">
        {purposeStore.list.map((tower, key) => (
          <ListItemTower
            key={key}
            tower={tower}
            onClick={() => {
              choosePc(tower);
              history.push("/");
              history.push("/final");
            }}
          />
        ))}
      </div>
    </div>
  );
}

export default inject("purposeStore")(observer(PurposeListScreen));
