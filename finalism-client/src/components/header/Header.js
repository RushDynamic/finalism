import React from 'react';
import { Link } from 'react-router-dom';

function Header() {
    return (<>
        <div className="header-container">
            <Link to='/'>
                <h1>finalism</h1>
            </Link>
        </div>
    </>)
}

export default Header;