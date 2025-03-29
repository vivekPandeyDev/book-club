function convertToUnderscore(str="") {
    return str.replace(/ /g, "_");
}

function getBookLink(bookName="",clubName=""){
    const bookNameUnderScore = convertToUnderscore(bookName)
    const clubNameUnderScore = convertToUnderscore(clubName)
    return `/book-detail/${clubNameUnderScore}/${bookNameUnderScore}`
}

function getBookReadingLink(bookName="",clubName=""){
    const bookNameUnderScore = convertToUnderscore(bookName)
    const clubNameUnderScore = convertToUnderscore(clubName)
    return `/book-reader/${clubNameUnderScore}/${bookNameUnderScore}`
}


export {getBookLink,convertToUnderscore,getBookReadingLink}