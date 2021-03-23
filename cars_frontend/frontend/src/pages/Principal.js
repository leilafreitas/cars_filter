import React, { useState,useEffect } from 'react';
import styled from 'styled-components';
import api from '../Helper/Api/Api';
import {Table} from '../components/Table';

export default function Principal ()
{

    const [infoList,setInfoList] = useState([]);
    const [titleList,setTitleList] = useState([]);
    const [title,setTitle] = useState("");
    const [currentSelection, setCurrentSelection] = useState(1);


    useEffect(()=>{

        getCars();
            
    },[]);

    
    const getCars = async() =>
    {
        const cars = await api.getCars();
        setInfoList(cars);
        setCurrentSelection(1); 
        setTitle("All Cars");
        setTitleList(Object.keys(cars[0]));
    }

    const getDamagedCars=async()=>
    {
        const dados= await api.getDamagedCars();
        setInfoList(dados);
        setCurrentSelection(3);
        setTitle("Damaged Cars soted by the value of damaged parts");
        setTitleList(Object.keys(dados[0]));
    }


    const getAllCarsByPartsValue=async()=>
    {
        const dados= await api.getAllCarsByPartsValue();
        setInfoList(dados);
        setCurrentSelection(2);
        setTitle("Cars soted by the value of parts");
        setTitleList(Object.keys(dados[0]));
    }

    const getParts=async()=>
    {
        const dados= await api.getDamagedParts();
        setInfoList(dados);
        setCurrentSelection(4);
        setTitle("Parts soted by the number of damaged parts");
        setTitleList(Object.keys(dados[0]));
    }

    const Container = styled.div`
        width:100vw;
        height:100vh;
        display:grid;
        grid-template-columns:8em 1fr 1fr 1fr 8em;
        grid-template-rows:1rem 7em 1rem 1fr 1rem;
        background-image:linear-gradient(to bottom right, #ffffff, #e2f6f5);
        overflow:hidden;

        @media screen and (max-width: 600px) {
            grid-template-columns:1em 1fr 1fr 1fr 1em;
            grid-template-rows:1rem 5em 1rem 1fr 1rem;
        }
    `;

    const Header = styled.div`
        grid-column: 2/5;
        grid-row:2;
        display:flex;
        align-items:center;
        justify-content:space-evenly;
    `;

    const Button = styled.div`
        width:20%;
        height:4em;
        background-color:${props => props.index === currentSelection? "#1e7f7f" : "#59d0ce"};
        border-radius:1rem;
        cursor: pointer;        
            
        span
        {
                height:100%;
                display:flex;
                align-items:center;
                justify-content:center;
                text-align:center;
                color:#ffffff;
                font-weight:bold;
        }

        &:hover{
                transition: 0.3s all ease;
                box-shadow: 0 0 1em #ACACAC;
                transform: scale(1.1);
        }

        @media screen and (max-width: 600px)
        {
            span
            {
                    height:100%;
                    text-align:center;
                    color:#ffffff;
                    font-weight:bold;
                    font-size: 0.7em;;
            }
        }        
    `;

    return( 
    <Container>
        <Header>
            <Button index= {1} onClick={()=> getCars()}><span>Cars List</span></Button>
            <Button index= {2} onClick={()=> getAllCarsByPartsValue()}><span>Sorted by Parts Value</span></Button>
            <Button index= {3} onClick={()=> getDamagedCars()}><span>Sorted by Damaged Parts Value</span></Button>
            <Button index= {4} onClick={()=> getParts()}><span>Damaged Parts</span></Button>
        </Header>
        <Table data={infoList} titles={titleList} titleTable={title}/>
    </Container>
    );
}
