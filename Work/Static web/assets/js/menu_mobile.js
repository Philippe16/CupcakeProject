// JavaScript Document

const dropdownRelativeContainer = document.querySelector("#navRelative_container");
const dropDownMenuIcon = document.querySelector("#menu_mobile");
const dropDownMenu = document.querySelector("#menu_mobile_container");

// Toggle the visibility of the dropdown menu when the menu button is clicked
dropDownMenuIcon.addEventListener("click", (event) => {

  if(dropDownMenu.style.display != "block"){
    dropDownMenu.style.display = "block";
    dropDownMenu.style.opacity = 1;
    localStorage.setItem('showDropdown', 'true');
  }else{
    dropDownMenu.style.display = "none";
    dropDownMenu.style.opacity = 0;
    localStorage.setItem('showDropdown', 'false');
  }

});

// Hide dropdown menu if the screen size gets wider than 660px
window.addEventListener("resize", (event) => {

  if(screen.width >= 661){
    dropDownMenu.style.display = "none";
    dropDownMenu.style.opacity = 0;
  }

});

// Hide dropdown menu if the window is minimized
document.addEventListener("visibilitychange", (event) => {

  console.log(document.hidden, document.visibilityState);
  dropDownMenu.style.display = "none";
  dropDownMenu.style.opacity = 0;

}, false);