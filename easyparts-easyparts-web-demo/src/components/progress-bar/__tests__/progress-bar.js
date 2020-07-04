import React from "react";
import renderer from "react-test-renderer";
import ProgressBar from "../progress-bar";
import { Provider } from "mobx-react";
import { CompareStore } from "../../../stores";

describe("CompareParts", () => {
  it("hasn't changed unexpectedly", () => {
    const part = { imagen: "", nombre: "" };
    const pc = {
      chassis: part,
      cpu: part,
      ram: part,
      gpu: part,
      motherboard: part,
      powerSource: part,
      storage1: part,
      storage2: part,
    };
    const tree = renderer
      .create(
        <Provider compareStore={CompareStore}>
          <ProgressBar pc={pc} returnToPart={() => {}} />
        </Provider>
      )
      .toJSON();
    expect(tree).toMatchSnapshot();
  });
});
