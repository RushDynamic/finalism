import { Segment, Header, Button, Icon } from "semantic-ui-react";
const ResultSegment = (resultFetched, shortUrl) => {
    return (resultFetched && (
        <Segment placeholder>
            <Header icon>
                <Button size='tiny' icon='copy outline' style={{ backgroundColor: '#F9FAFB' }} onClick={() => { navigator.clipboard.writeText(shortUrl) }} />
                {`Here's your shortened URL: ${shortUrl}`}
            </Header>
        </Segment>)
    )
}

export default ResultSegment;