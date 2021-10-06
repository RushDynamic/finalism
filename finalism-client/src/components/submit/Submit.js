import React, { useState } from "react";
import { Input, Segment, Header, Icon } from "semantic-ui-react";
import '../../styles/submit.scss';
import { shortenUrl } from "../../services/finalism-api-service";
import ResultSegment from './ResultSegment.js';

function Submit() {
    const [resultFetched, setResultFetched] = useState(true);
    const [inputUrl, setInputUrl] = useState("");
    const [outputUrl, setOutputUrl] = useState("");

    const handleOnSubmitUrl = async () => {
        const respData = await shortenUrl(inputUrl);
        console.log(respData);
        setOutputUrl(respData.shortenUrlOutput.shortenedUrl);
    }

    const handleOnSubmitUrlChange = async (e) => {
        setInputUrl(e.target.value);
    }

    return (
        <div className='submit-container'>
            <div className='submit-inner-container'>
                <Input size='huge' onChange={handleOnSubmitUrlChange} className='submit-input-field' action={{ icon: 'cut', onClick: handleOnSubmitUrl }} placeholder='Enter a URL...' />
            </div>
            <div className='result-container'>
                {ResultSegment(resultFetched)}
                {outputUrl != "" && <h1>Shortened URL: finalism.com/{outputUrl}</h1>}
            </div>
        </div>)
}

export default Submit;