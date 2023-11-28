import React from "react";

function Sell() {
  return (
    <div className="flex flex-row justify-evenly w-11/12 pb-12 mt-16 mx-auto bg-mainBg bg-cover bg-center py-16 px-20 border-8 border-mainCol">
      <div className="p-16 bg-gray-400 bg-opacity-50 flex items-center">
        <svg
          xmlns="http://www.w3.org/2000/svg"
          fill="none"
          viewBox="0 0 24 24"
          strokeWidth={1}
          stroke="currentColor"
          className="w-24 h-24 -mx-6"
        >
          <path
            strokeLinecap="round"
            strokeLinejoin="round"
            d="M12 4.5v15m7.5-7.5h-15"
          />
        </svg>

        <svg
          xmlns="http://www.w3.org/2000/svg"
          fill="none"
          viewBox="0 0 24 24"
          strokeWidth={0.5}
          stroke="currentColor"
          className="w-48 h-48"
        >
          <path
            strokeLinecap="round"
            strokeLinejoin="round"
            d="M2.25 15.75l5.159-5.159a2.25 2.25 0 013.182 0l5.159 5.159m-1.5-1.5l1.409-1.409a2.25 2.25 0 013.182 0l2.909 2.909m-18 3.75h16.5a1.5 1.5 0 001.5-1.5V6a1.5 1.5 0 00-1.5-1.5H3.75A1.5 1.5 0 002.25 6v12a1.5 1.5 0 001.5 1.5zm10.5-11.25h.008v.008h-.008V8.25zm.375 0a.375.375 0 11-.75 0 .375.375 0 01.75 0z"
          />
        </svg>
      </div>
      <div className="flex items-center">
        <div className=" bg-white border-4 border-mainCol p-8 w-fit h-fit">
          <h1>Product Name</h1>
          <h1>Description</h1>
          <h1>Category</h1>
          <h1>Starting Price</h1>
          <h1>End Date</h1>
        </div>
      </div>
    </div>
  );
}

export default Sell;
