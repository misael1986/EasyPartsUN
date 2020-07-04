import React, { useState } from "react";
import "./pc-filters.css";
import { FaArrowAltCircleDown, FaArrowAltCircleLeft } from "react-icons/fa";
import { TiRefresh } from "react-icons/ti";

function PcFilters({ filters, selectFilter, resetFilters }) {
  const [showArr, setShowArr] = useState(new Array(filters.length).fill(true));

  const showValues = (key) => {
    const newArr = [...showArr];
    newArr[key] = !newArr[key];
    setShowArr(newArr);
  };

  return (
    <div className="PcFilters">
      {filters.map((filter, key) => {
        return (
          <div key={key}>
            <button className="top" onClick={() => showValues(key)}>
              <p className="topText">{filter.name}</p>
              {showArr[key] ? (
                <FaArrowAltCircleLeft size={14} color="white" />
              ) : (
                <FaArrowAltCircleDown size={14} color="white" />
              )}
            </button>

            <div className="List">
              {showArr[key] &&
                filter.values.map((item, key) => {
                  return (
                    <button
                      key={key}
                      className={
                        filter.selected === item
                          ? "listItemSelected"
                          : "listItem"
                      }
                      onClick={() => {
                        selectFilter(filter, item);
                      }}
                    >
                      {item}
                    </button>
                  );
                })}
            </div>
          </div>
        );
      })}
      <button className="reset" onClick={() => resetFilters(filters)}>
        <TiRefresh size={26} color="white" />
        <p className="resetText">Resetear</p>
      </button>
    </div>
  );
}

export default PcFilters;
