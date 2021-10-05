import React, { useState } from "react";
import { Input, Segment, Header, Icon } from "semantic-ui-react";
import '../../styles/submit.scss';

const ResultSegment = (resultFetched) => {
    return (resultFetched && (
        <Segment placeholder>
            <Header icon>
                <Icon name="world" />
                Here's your shortened URL
            </Header>
        </Segment>)
    )
}

function Submit() {
    const [resultFetched, setResultFetched] = useState(false);

    return (
        <div className='submit-container'>
            <div className='submit-inner-container'>
                <Input className='submit-input-field' action='Submit' placeholder='Enter a URL...' />
            </div>
            <div className='result-container'>
                {ResultSegment(resultFetched)}
            </div>
        </div>)
}

export default Submit;