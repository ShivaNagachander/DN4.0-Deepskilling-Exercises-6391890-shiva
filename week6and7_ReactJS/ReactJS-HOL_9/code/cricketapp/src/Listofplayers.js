
export const ListofPlayers=({players})=>
{

    return(
        <div>
            <h1>List of players</h1>
            <ul>
                {players.map((item)=>
                {
                    return(
                    <div>
                        <li>MR.{item.name}<span> {item.score}</span></li>
                    </div>
                    )
                }
            )}
            </ul>
            <hr/>
        </div>
)
};

export const ListofPlayers70=({players})=>{
    var players70=[];
    return(
        <div>
            <h1>players with score below 70</h1>
                {players.map((item)=>
                {
                    if(item.score<=70)
                    {
                        players70.push(item);
                    }
                })
                }
            <ul>
                {players70.map((item)=>
                {
                    return(
                    <div>
                        <li>MR.{item.name}<span> {item.score}</span></li>
                    </div>
                    )
                
                }
            )}
            </ul>
            <hr/>
        </div>
    )
}

export function Oddplayers({players:[first,,third,,fifth,,seventh,,ninth,,eleventh]})
{
    return(
        <div>
            <h1>Odd team players</h1>
            <li>First: {first.name} {first.score}</li>
            <li>Third: {third.name} {third.score}</li>
            <li>Fifth: {fifth.name} {fifth.score}</li>
            <li>Seventh: {seventh.name} {seventh.score}</li>
            <li>Ninth: {ninth.name} {ninth.score}</li>
            <li>Eleventh: {eleventh.name} {eleventh.score}</li>
            <hr/>
        </div>
    );
}
export function Evenplayers({ players: [, second, , fourth, , sixth, , eighth, , tenth] }) {
    return (
        <div>
            <h1>Even team players</h1>
            <li>Second: {second.name} {second.score}</li>
            <li>Fourth: {fourth.name} {fourth.score}</li>
            <li>Sixth: {sixth.name} {sixth.score}</li>
            <li>Eighth: {eighth.name} {eighth.score}</li>
            <li>Tenth: {tenth.name} {tenth.score}</li>
            <hr/>
        </div>
    );
}
const T20Players = ['First Player', 'Second Player', 'Third Player'];
const RanjiTrophyPlayers =['Fourth Player', 'Fifth Player', 'Sixth Player'];

export const IndianPlayers=[...T20Players, ...RanjiTrophyPlayers];
export function MergedPlayerList() {
  return (
    <div>
      <h1>Merged Indian Players List</h1>
      <ul>
        {IndianPlayers.map((player) => (
          <li>{player}</li>
        ))}
      </ul>
    </div>
  );
}

