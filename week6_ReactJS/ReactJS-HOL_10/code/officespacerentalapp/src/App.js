import './App.css';
import officeImg from './Office_Cabin_u03.jpg';
function App() {
  const element = "Office space";
  const ItemName = [
    { Name: "DBS", Rent: 102000, Address: 'Hyderabad'},
    { Name: "WeWork", Rent: 55000, Address: 'Bangalore'},
    { Name: "CoWorks", Rent: 60000, Address: 'Pune'}
  ];
  const jsxatt=<img src={officeImg} width="25%" height="25%" alt="office space"/>;
  return (
    <div className="App">
      <h1>{element} , at affordable range</h1>
      <div className="container">
        {
          ItemName.map((item, index) => {
            let colors = [];
            if (item.Rent <= 60000) {
              colors.push('textRed');
            }
            else {
              colors.push('textGreen');
            }
            return (
              <div key={index} className="item">
                {jsxatt}
                <p>name: {item.Name}</p>
                <p className={colors.join('')}>rent: Rs.{item.Rent}</p>
                <p>address: {item.Address}</p>
              </div>
            );
          })
        }
      </div>
    </div>
  );
}
export default App;
