import './App.css';
var counter=0;
function increment() 
{
  counter++;
  alert("Hello Member : "+counter);
}
function decrement()
{
  counter--;
  alert("Hello Member : "+counter);
}
function sayWelcome()
{
  alert("welcome");
}
function clickMe()
{
  alert("i was clicked");
}
function submit()
{
  const amount = parseFloat(document.getElementById('amount').value);
  const currency = document.getElementById('currency').value;
  const euroRate = 0.85;
  const result=amount*euroRate;
  alert('Converted to '+currency+' amount is '+result.toFixed(2));
}
function App() {
  return (
    <div className="App">
      <button onClick={increment}>Increment</button>
      <button onClick={decrement}>Decrement</button>
      <button onClick={sayWelcome}>say welcome</button>
      <button onClick={clickMe}>Click me</button>

      <br/>
    <h1 style={{ color: 'green' }}>currency converter!!!</h1>
      <p>amount <input type='text' id='amount'/></p>
      <p>currency : <input type='text' id='currency'/></p>
      <button onClick={submit}>submit</button>
    </div>
  );
}

export default App;
