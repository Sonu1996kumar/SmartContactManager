let currentTheme =getTheme();

//console.log(currentTheme)
//initially run
document.addEventListener('DOMContentLoaded',()=>{
    changeTheme();
});

//todo
function changeTheme(){

    //set the listener to change the button
    const changeThemeButton = document.querySelector("#theme_change_button");
    
    
    changeThemeButton.addEventListener("click", (event) => {
        const oldTheme = currentTheme;
        
        if(currentTheme ==="dark"){
            currentTheme = "light";
        }else{
            currentTheme = "dark";
        }
        
        //local storage me update karega
        setTheme(currentTheme);
        //remove the current theme
        document.querySelector("html").classList.remove(oldTheme);
        //add the current theme
        document.querySelector("html").classList.add(currentTheme);
        changeThemeButton.querySelector("span").textContent = currentTheme === "light" ? "Dark" : "Light";

    });
}



//set theme to local storage

function setTheme(theme) {
    localStorage.setItem('theme', theme);
   
 }

 //get theme from local storage
 function getTheme() {
     let theme=localStorage.getItem('theme');
     return theme ? theme : "light";
    
    
 }

 