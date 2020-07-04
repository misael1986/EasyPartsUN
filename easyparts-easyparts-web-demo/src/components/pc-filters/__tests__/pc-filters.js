import React from "react";
import renderer from "react-test-renderer";
import PcFilters from "../pc-filters";
import { Provider } from "mobx-react";
import { SearchStore } from "../../../stores";

describe("PcFilters", () => {
  it("hasn't changed unexpectedly", () => {
    const tree = renderer
      .create(
        <Provider searchStore={SearchStore}>
          <PcFilters
            filters={[{ values: [1, 2] }]}
            selectFilter={() => {}}
            resetFilters={() => {}}
          />
        </Provider>
      )
      .toJSON();
    expect(tree).toMatchSnapshot();
  });
});
