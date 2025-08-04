import './App.css';
import { Evenplayers, ListofPlayers, ListofPlayers70, MergedPlayerList, Oddplayers} from './Listofplayers';

const players=[
        {name:"dhoni",score:82},
        {name:"kohli",score:90},
        {name:"rohit",score:40},
        {name:"hardik",score:22},
        {name:"jadeja",score:31},
        {name:"bhuvi",score:12},
        {name:"bumrah",score:1},
        {name:"shreyas",score:78},
        {name:"rahul",score:121},
        {name:"ashwin",score:4},
        {name:"kuldeep",score:0},
    ];
function App() {
  const flag=false;
  if(flag===true){
    return (
      <div className="App">
        <ListofPlayers players={players}/>
        <ListofPlayers70 players={players}/>
      </div>
    );
  }
  else{
    return (
      <div className="App">
        <Oddplayers players={players}/>
        <Evenplayers players={players}/>
        <MergedPlayerList/>
      </div>
    );
  }
}
export default App;