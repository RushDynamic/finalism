import React from "react";
import { Input, Segment } from "semantic-ui-react";
import '../../styles/submit.scss';

function Submit() {
    return (
        <div className='submit-container'>
            <div className='submit-inner-container'>
                <Input className='submit-input-field' action='Submit' placeholder='Enter a URL...' />
            </div>
        </div>)
}

export default Submit;