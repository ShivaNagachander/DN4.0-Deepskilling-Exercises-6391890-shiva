import React from "react";
class CountPeople extends React.Component
{
    constructor()
    {
    super();
    this.state = {
        entrycount: 0,
        exitcount: 0,
        c: 0
    };
    }
    updateEntry=()=> {
        this.setState((prevState, props) => {
            return { entrycount: prevState.entrycount + 1 };
        });
    }
    updateExit=()=> {
        this.setState((prevState, props) => {
        return { exitcount: prevState.exitcount + 1 };
        });
    }
    render()
    {
        return(
            <div>
                <button onClick={this.updateEntry}>Login</button>
                <p>{this.state.entrycount} people entered!!</p>
                <br/>
                <button onClick={this.updateExit}>Exit</button>
                <p>{this.state.exitcount} people left!!</p>
            </div>
        );
    }

}
export default CountPeople;