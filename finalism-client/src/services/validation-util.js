export function validateUrl(inputUrl) {
    if (!inputUrl.startsWith("http://") && !inputUrl.startsWith("https://")) {
        inputUrl = "http://" + inputUrl;
    }
    var res = inputUrl.match(/(http(s)?:\/\/.)?(www\.)?[-a-zA-Z0-9@:%._\+~#=]{2,256}\.[a-z]{2,6}\b([-a-zA-Z0-9@:%_\+.~#?&//=]*)/g);
    return res != null;
}

export function formatUrl(inputUrl) {
    if (!inputUrl.startsWith("http://") && !inputUrl.startsWith("https://")) {
        return "http://" + inputUrl;
    }
}