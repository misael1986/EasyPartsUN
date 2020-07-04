import React, { useEffect } from "react";
import "./main-screen.css";
import {
  CompareParts,
  NavBarInternal,
  PcFilters,
  PcPart,
  ProgressBar,
  ProgressBarQuantities,
  SearchBar,
} from "../../components";
import { inject, observer } from "mobx-react";
import {
  addToCompare,
  choosePart,
  getListFromService,
  goToFinalScreen,
  resetFilters,
  returnToPart,
  selectFilter,
} from "./main-screen-logic";
import { useHistory } from "react-router-dom";

function MainScreen({ searchStore, userStore }) {
  const history = useHistory();

  useEffect(() => {
    getListFromService(searchStore.typeSelected);
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  return (
    <div className="screen">
      <NavBarInternal route="/estiloEP" />
      <div className="MainScreen">
        <div className="LeftPanel">
          <h1>EasyParts</h1>
          <PcFilters
            filters={searchStore.filterFromType}
            selectFilter={selectFilter}
            resetFilters={resetFilters}
          />
        </div>
        <div className="RightPanel">
          <ProgressBarQuantities
            quantities={userStore.quantities}
            setRamQuantity={userStore.setRamQuantity.bind(userStore)}
            setStorageQuantity={userStore.setStorageQuantity.bind(userStore)}
          />
          <ProgressBar pc={userStore.pc} returnToPart={returnToPart} />
          <>
            <div className="Heading">
              <h4 className="PcPower">{userStore.pcPower} Watts</h4>
              <h2>Escoge tu {searchStore.componentDescription}</h2>
              <h5>
                (Sólo te mostramos componentes compatibles con los que ya has
                elegido)
              </h5>
            </div>
            <SearchBar
              value={searchStore.searchText}
              onChange={(event) =>
                (searchStore.searchText = event.target.value)
              }
            />
            <div className="PcPartsList">
              {searchStore.searchListFiltered.map((item) => {
                return (
                  <PcPart
                    key={item.id}
                    item={item}
                    choosePart={() => {
                      choosePart(item);
                      if (item.type === "powerSource") {
                        goToFinalScreen(history);
                      }
                    }}
                    addToCompare={addToCompare}
                  />
                );
              })}
            </div>
          </>
        </div>
        <CompareParts />
      </div>
    </div>
  );
}

export default inject("searchStore", "userStore")(observer(MainScreen));
