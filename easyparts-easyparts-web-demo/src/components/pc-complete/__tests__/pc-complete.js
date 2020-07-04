import React from "react";
import renderer from "react-test-renderer";
import PcComplete from "../pc-complete";

jest.mock("react-router-dom", () => ({
  useHistory: () => ({
    push: jest.fn(),
  }),
}));

describe("PcComplete", () => {
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
    const tree = renderer.create(<PcComplete pc={pc} />).toJSON();
    expect(tree).toMatchSnapshot();
  });
});
