import { Segment, Header, Icon } from "semantic-ui-react";
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

export default ResultSegment;