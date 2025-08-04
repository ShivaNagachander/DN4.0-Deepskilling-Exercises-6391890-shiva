import Cart from "./Cart";
import React from "react";
class OnlineShopping extends React.Component
{
    render()
    {
        const CartInfo=[
            {itemname:"TV",price:10000},
            {itemname:"Washing machine",price:20000},
            {itemname:"Mobile",price:30000},
            {itemname:"Fridge",price:25000}
        ];
        return(
            <div className="mydiv">
                <h1>items ordered : </h1>
                <Cart item={CartInfo}/>
            </div>
        );
    }
}
export default OnlineShopping;