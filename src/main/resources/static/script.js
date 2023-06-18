function onPlusClicked() {
    let fullId = this.id; // otrzymuję id przecisku na ktorym wywolano tą metodę
    let fullIdArray = fullId.split("-");
    let idNumber = fullIdArray[1];
    console.log(idNumber);
    let label = document.querySelector('#label-' + idNumber);
    let contentAsNumber = parseInt(label.innerHTML);
    contentAsNumber++;
    label.innerHTML = contentAsNumber;
    let hiddenInput = document.querySelector('#dish-count-' + idNumber);
    hiddenInput.setAttribute('value', contentAsNumber);
}
let buttons = document.querySelectorAll(".plus");
for (const button of buttons) {
    button.addEventListener('click', onPlusClicked);
}

//element = document.querySelector(selectors);
//wpisywanie slektorów:
//np. "div" da wszystkie elementy danego typu
//np. ".hello" da wszystkie elementy z KLASA 'hello'
//np. "#hello" da element z id 'hello'


//na moment wcisniecia przycisku + wykonaj nastepujacy kod:
//odczytaj liczbę w odpowiednim label
//zwieksz liczbe o 1
//nadpisz wartosc nowa liczba

// onPlusClicked();

// let naglowek = document.querySelector('h2');
// console.log(naglowek.innerHTML);

// document.querySelector('button').innerHTML = 'TEST';

// let button = document.querySelector('#dish-button');
// button.addEventListener('click',onPlusClicked);