import React from "react";
import renderer from "react-test-renderer";
import ProgressBarPart from "../progress-bar-part";

describe("ProgressBarPart", () => {
  it("hasn't changed unexpectedly", () => {
    const part = { imagen: "", nombre: "" };
    const tree = renderer
      .create(
        <ProgressBarPart
          type="cpu"
          part={part}
          name="Procesador"
          returnToPart={() => {}}
        />
      )
      .toJSON();
    expect(tree).toMatchSnapshot();
  });
});
