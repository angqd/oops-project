import React from "react";

const Dashboard = () => {
  return (
    <div className="grid grid-cols-1 sm:grid-cols-2 gap-6 w-11/12 pb-12 mt-16 mx-auto bg-mainBg bg-cover bg-center py-16 px-20 border-8 border-mainCol">
      <div className=" p-4  flex flex-col gap-2 justify-center">
        <h1 className="font-bold text-4xl sm:text-4xl sm:tracking-wider uppercase">
          Welcome <br /> Ishan Barpanda
        </h1>
        <button className="bg-white text-mainCol w-1/2 md:w-1/4 px-6 py-2 border-2 hover:bg-mainCol hover:text-white transition-all border-mainCol font-bold text-md">
          Logout
        </button>
      </div>
      <div className="bg-white p-4 border-4 border-mainCol flex flex-row justify-evenly">
        <img src="wallet.jpg" alt="wallet" className="h-40 object-center" />
        <div className="flex flex-col gap-2 justify-center">
          <h1 className="font-bold sm:text-xl text-black">
            Balance: <span className="text-red">30,000 BTC</span>
          </h1>
          <button className="bg-mainCol text-white md:w-fit px-6 py-2 hover:text-mainCol hover:bg-white border-mainCol border-2 transition-all font-bold text-md">
            View More
          </button>
        </div>
      </div>
      <div className="bg-white border-4 border-mainCol p-8 flex flex-col justify-center items-center">
        <h1>Email:</h1>
        <h1>Phone no:</h1>
        <h1>Hostel:</h1>
      </div>
      <div className="bg-white border-4 border-mainCol flex flex-row justify-center">
        <div className=" p-8 flex flex-col justify-center items-center">
          {" "}
          <svg
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            strokeWidth={1}
            stroke="currentColor"
            className="w-32 h-32"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              d="M17.982 18.725A7.488 7.488 0 0012 15.75a7.488 7.488 0 00-5.982 2.975m11.963 0a9 9 0 10-11.963 0m11.963 0A8.966 8.966 0 0112 21a8.966 8.966 0 01-5.982-2.275M15 9.75a3 3 0 11-6 0 3 3 0 016 0z"
            />
          </svg>
          <button className="bg-mainCol text-white w-1/2 md:w-fit px-6 py-2 hover:text-mainCol hover:bg-white border-mainCol border-2 transition-all font-bold text-md">
            Buyer Dashboard
          </button>
        </div>
        <div className="p-8 flex flex-col justify-center items-center">
          {" "}
          <svg
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            strokeWidth={1}
            stroke="currentColor"
            className="w-32 h-32"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              d="M17.982 18.725A7.488 7.488 0 0012 15.75a7.488 7.488 0 00-5.982 2.975m11.963 0a9 9 0 10-11.963 0m11.963 0A8.966 8.966 0 0112 21a8.966 8.966 0 01-5.982-2.275M15 9.75a3 3 0 11-6 0 3 3 0 016 0z"
            />
          </svg>
          <button className="bg-mainCol text-white w-1/2 md:w-fit px-6 py-2 hover:text-mainCol hover:bg-white border-mainCol border-2 transition-all font-bold text-md">
            Seller Dashboard
          </button>
        </div>
      </div>
    </div>
  );
};

export default Dashboard;
