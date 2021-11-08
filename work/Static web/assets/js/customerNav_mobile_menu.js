// JavaScript Document

const dropDownMenuBtn = document.querySelector("#customerNav_mobile_container");
const dropDownMenu = document.querySelector("#customerNav_mobile_menu_container");

// Toggle the visibility of the dropdown menu when the menu button is clicked
dropDownMenuBtn.addEventListener("click", (event) => {

  if(dropDownMenu.style.display != "block"){
    dropDownMenu.style.display = "block";
  }else{
    dropDownMenu.style.display = "none";
  }

});

// Hide dropdown menu if the screen size gets wider than 770px
window.addEventListener("resize", (event) => {

  if(screen.width >= 770){
    dropDownMenu.style.display = "none";
  }

});