import React from "react";
import styled from "styled-components";

const StyledTable = styled.table`
  width:100%;
  max-height:80%;
  caption-side: top;
  border: none;
  border-collapse: collapse;

  caption-side: top;

  td,
  th {
    border: none;
    width:33%;
    text-transform: capitalize;
    padding:0.1rem; 
  }

  th{
    color:#ffffff;
  }

  td {
    text-align:center;   
  }
  
  tbody {
    display: block;
    max-height:30rem;
    overflow:scroll;

   ::-webkit-scrollbar {
        width: 6px;
        background: #ffffff;
            
    }  
    ::-webkit-scrollbar-thumb{
        background-color:#1a3f3f;
        border-radius:1px;
    } 
}

  thead, tbody tr {
    display: table;
    width: 100%;
    table-layout: fixed;
}

  tbody tr {
    :nth-of-type(odd) {
      background-color: #ffffff;
    }
    :nth-of-type(even) {
      background-color: #dcdcdc;
    }
    :hover {
      color:#ffffff;
      background-color: #18a2a1;
    }
  }
  thead > tr {
    background-color: #8b8b8b;
  }
  caption {
    font-size: 0.9em;
    padding: 5px;
    font-weight: bold;
  }
`;

const Container = styled.div`
  grid-column:2/5;
  grid-row:4;
  overflow-y: hidden;
`;

export const Table = ({data,titles,titleTable}) => {
  
  return(
    <Container>
      <StyledTable>
        <caption>{titleTable}</caption>
        <colgroup>
          {titles.map((title, index) => (
              <col key={index}/>
          ))}
        </colgroup>
        <thead>
          <tr>
            {titles.map((title, index) => (
              <th key={index}>{title}</th>
            ))}
          </tr>
        </thead>
        <tbody>
          {data.map((item, index) => (
            <tr key={index}>
              {titles.map((title, index) => (
                <td key={index}>{item[title]}</td>
              ))}
            </tr>
          ))}
        </tbody>
      </StyledTable>
    </Container>
  );
};

