let button = document.querySelector('.button');
let inputMin = document.querySelector('#input-min');
let inputMax = document.querySelector('#input-max');
let result = document.querySelector('.result');
let value = document.querySelector('.result .value');

button.addEventListener('click', gerarNumero);

function gerarNumero() {

  let min = parseInt(inputMin.value);
  let max = parseInt(inputMax.value);

  let random = randomInteger(min, max);

  result.style.display = 'initial';
  value.innerHTML = random;
}

function randomInteger(min, max) {
  return Math.floor(Math.random() * (max - min + 1)) + min;
}
