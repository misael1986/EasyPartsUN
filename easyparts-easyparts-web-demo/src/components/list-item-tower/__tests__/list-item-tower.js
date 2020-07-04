import React from "react";
import renderer from "react-test-renderer";
import ListItemTower from "../list-item-tower";
import { Provider } from "mobx-react";
import { SearchStore } from "../../../stores";

describe("PcFilters", () => {
  it("hasn't changed unexpectedly", () => {
    const part = { imagen: "", nombre: "" };
    const tower = {
      gabinete: part,
      procesador: part,
      ram: part,
      tarjetaVideo: part,
      discos: [part, part],
      preciototal: "",
    };
    const tree = renderer
      .create(
        <Provider searchStore={SearchStore}>
          <ListItemTower tower={tower} onClick={() => {}} />
        </Provider>
      )
      .toJSON();
    expect(tree).toMatchSnapshot();
  });
});
