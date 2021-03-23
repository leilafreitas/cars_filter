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
        setTitle("Todos os veículos");
        setTitleList(Object.keys(cars[0]));
    }

    const getDamagedCars=async()=>
    {
        const dados= await api.getDamagedCars();
        setInfoList(dados);
        setCurrentSelection(3);
        setTitle("Veículos dafinicados ornedados pelo valor dos danos");
        setTitleList(Object.keys(dados[0]));
    }


    const getAllCarsByPartsValue=async()=>
    {
        const dados= await api.getAllCarsByPartsValue();
        setInfoList(dados);
        setCurrentSelection(2);
        setTitle("Veículos ordenados pelo valor total das peças");
        setTitleList(Object.keys(dados[0]));
    }

    const getParts=async()=>
    {
        const dados= await api.getDamagedParts();
        setInfoList(dados);
        setCurrentSelection(4);
        setTitle("Peças ordenadas pela quantidade danificada");
        setTitleList(Object.keys(dados[0]));
    }

    const Container = styled.div`
        width:100vw;
        height:100vh;
        display:grid;
        min-width:350px;
        grid-template-columns:8em 1fr 1fr 1fr 8em;
        grid-template-rows:1rem 7em 1rem 1fr 1rem;
        background-image:linear-gradient(to bottom right, #ffffff, #e2f6f5);
        overflow:hidden;

        @media screen and (max-width: 700px) {
            grid-template-columns:1em 1fr 1fr 1fr 1em;
            grid-template-rows:1rem 4em 1rem 1fr 2rem;
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
        width:22%;
        height:4em;
        padding:0.1rem;
        background-color:${props => props.index === currentSelection? "#59d0ce" : "#ffffff"};
        border-radius:1rem;
        border:0.1rem solid #59d0ce;
        
        cursor: pointer;        
            
        span
        {
                height:100%;
                display:flex;
                align-items:center;
                justify-content:center;
                text-align:center;
                color:${props => props.index === currentSelection? "#ffffff" : "#59d0ce"};
                font-weight:bold;
        }

        &:hover{
                transition: 0.3s all ease;
                box-shadow: 0 0 1em #ACACAC;
                transform: scale(1.1);
        }

        @media screen and (max-width: 700px)
        {
            span
            {
                    font-size: 0.7em;
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
