import React, { useState } from "react";
import { Input, Segment, Header, Icon } from "semantic-ui-react";
import '../../styles/submit.scss';
import ResultSegment from './ResultSegment.js';

function Submit() {
    const [resultFetched, setResultFetched] = useState(true);
    const [inputUrl, setInputUrl] = useState("");

    const handleOnSubmitUrl = () => {
    }

    const handleOnSubmitUrlChange = (e) => {
        setInputUrl(e.target.value);
    }

    return (
        <div className='submit-container'>
            <div className='submit-inner-container'>
                <Input size='huge' onChange={handleOnSubmitUrlChange} className='submit-input-field' action={{ icon: 'cut', onClick: handleOnSubmitUrl }} placeholder='Enter a URL...' />
            </div>
            <div className='result-container'>
                {ResultSegment(resultFetched)}
            </div>
        </div>)
}

export default Submit;