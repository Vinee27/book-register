
let card=document.querySelector(".trend");
let card1=document.getElementById("trend1");
let card2=document.getElementById("trend2");
let mainPage=document.querySelector(".main");
let abouts=document.getElementById("abouts");
let about1=document.querySelector(".about");
let contacts=document.querySelector(".contact");

function home(){
    mainPage.style.display="flex";
    card.style.display="none";
    card1.style.display="none";
    card2.style.display="none";
    about1.style.display="none";
    contacts.style.display="none";

    document.getElementById("abouts").style.color="black";
    document.getElementById("homes").style.color="skyblue";
    document.getElementById("products").style.color="black";
    document.getElementById("contacts").style.color="black";

}

function product(){
    mainPage.style.display="none";
    about1.style.display="none";
    card.style.display="block";
    card1.style.display="block";
    card2.style.display="block";
    contacts.style.display="none";

    document.getElementById("abouts").style.color="black";
    document.getElementById("homes").style.color="black";
    document.getElementById("products").style.color="skyblue";
    document.getElementById("contacts").style.color="black";
    
}
function about(){
    mainPage.style.display="none";
    card.style.display="none";
    card1.style.display="none";
    card2.style.display="none";
    about1.style.display="block";
    contacts.style.display="none";

    document.getElementById("abouts").style.color="skyblue";
    document.getElementById("homes").style.color="black";
    document.getElementById("products").style.color="black";
    document.getElementById("contacts").style.color="black";
}

function contact(){
    mainPage.style.display="none";
    card.style.display="none";
    card1.style.display="none";
    card2.style.display="none";
    about1.style.display="none";
    contacts.style.display="block";

    document.getElementById("abouts").style.color="black";
    document.getElementById("homes").style.color="black";
    document.getElementById("products").style.color="black";
    document.getElementById("contacts").style.color="skyblue";

}


function show(img){
    let newImg=document.getElementById("newImg");
    console.log(img);
    newImg.src=img.src;

    mainPage.style.display="none";
    card.style.display="none";
    card1.style.display="none";
    card2.style.display="none";
    about1.style.display="none";
    contacts.style.display="none";

    document.querySelector(".cart").style.display="flex";
}

