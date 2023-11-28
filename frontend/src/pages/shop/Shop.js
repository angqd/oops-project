import React from "react";

const Shop = () => {
  return (
    <>
      <div className="w-11/12  mt-16 top-1/2 mx-auto p-4 bg-white border-8 border-mainCol flex flex-row">
        <div>
          <svg
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            strokeWidth={1.5}
            stroke="currentColor"
            className="w-6 h-6"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              d="M21 21l-5.197-5.197m0 0A7.5 7.5 0 105.196 5.196a7.5 7.5 0 0010.607 10.607z"
            />
          </svg>
        </div>
        <h1>FILTER</h1>
        <h1>SORT</h1>
      </div>
      <div className=" w-11/12 pb-12 mt-12 top-1/2 mx-auto bg-mainBg bg-cover bg-center p-4 border-8 border-mainCol flex flex-row"></div>
    </>
  );
};

export default Shop;
