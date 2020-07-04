import React from "react";
import renderer from "react-test-renderer";
import SearchBar from "../search-bar";
import { SearchStore } from "../../../stores";
import { Provider } from "mobx-react";

import "mobx-react-lite/batchingForReactDom";

describe("CompareParts", () => {
  it("hasn't changed unexpectedly", () => {
    const tree = renderer
      .create(
        <Provider searchStore={SearchStore}>
          <SearchBar value="" onChange={() => {}} />
        </Provider>
      )
      .toJSON();
    expect(tree).toMatchSnapshot();
  });
});
