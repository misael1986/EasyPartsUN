import React from "react";
import renderer from "react-test-renderer";
import CompareParts from "../compare-parts";
import { Provider } from "mobx-react";
import { CompareStore } from "../../../stores";

import "mobx-react-lite/batchingForReactDom";

describe("CompareParts", () => {
  it("hasn't changed unexpectedly", () => {
    const tree = renderer
      .create(
        <Provider compareStore={CompareStore}>
          <CompareParts />
        </Provider>
      )
      .toJSON();
    expect(tree).toMatchSnapshot();
  });
});
