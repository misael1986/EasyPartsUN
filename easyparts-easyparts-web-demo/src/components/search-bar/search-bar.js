import React from "react";
import "./search-bar.css";
import searchIcon from "../../assets/search.svg";
import { inject, observer } from "mobx-react";

import { FaSearch } from "react-icons/fa";

function SearchBar({ value, onChange }) {
  return (
    <div className="SearchBar">
      <input
        className="SearchInput"
        placeholder="Busca por nombre..."
        value={value}
        onChange={onChange}
      />
      <FaSearch className="SearchGlass" src={searchIcon} alt="lupa" />
    </div>
  );
}

export default inject("searchStore")(observer(SearchBar));
