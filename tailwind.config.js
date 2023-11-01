/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,js}"],
  theme: {
    extend: {
      colors: {
        mainCol: "#BCA37F",
        bgCol: "#FFF2D8",
      },
      fontFamily: {
        poppins: ["Poppins", "sans-serif"],
      },
      backgroundImage: {
        mainBg: "url('/public/bg1.png')",
      },
    },
  },
  plugins: [],
};
