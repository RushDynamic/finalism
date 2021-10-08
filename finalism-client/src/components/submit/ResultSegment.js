import { Segment, Header, Button } from "semantic-ui-react";
const ResultSegment = (resultFetched, shortUrl) => {
    return (resultFetched && (
        <Segment placeholder>
            <Header icon>
                <Button size='tiny' icon='copy outline' style={{ backgroundColor: '#F9FAFB', marginBottom: '2vh', marginTop: '2vh' }} onClick={() => { navigator.clipboard.writeText(shortUrl) }} />
                <div>
                    <h4>Here's your shortened URL:</h4>
                    <h2 style={{ marginTop: '0vh' }}>{shortUrl}</h2>
                </div>
            </Header>
        </Segment>)
    )
}

export default ResultSegment;