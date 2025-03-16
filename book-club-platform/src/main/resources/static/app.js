const uploadBook = async () => {
    // Clear previous error messages
    document.querySelectorAll('.error').forEach(error => error.textContent = '');

    const bookData = {
        title: document.getElementById('title').value.trim(),
        author: document.getElementById('author').value.trim(),
        genre: document.getElementById('genre').value.trim(),
        language: document.getElementById('language').value.trim(),
        publishedYear: document.getElementById('publishedYear').value,
        rating: document.getElementById('rating').value
    };

    const file = document.getElementById('fileInput').files[0];
    const coverImage = document.getElementById('coverImageInput').files[0];

    // Validation
    let isValid = true;

    if (!bookData.title) {
        document.getElementById('titleError').textContent = 'Title is required';
        isValid = false;
    }
    if (!bookData.author) {
        document.getElementById('authorError').textContent = 'Author is required';
        isValid = false;
    }
    if (!file) {
        document.getElementById('fileError').textContent = 'Book file is required';
        isValid = false;
    }
    if (!coverImage) {
        document.getElementById('coverImageError').textContent = 'Cover image is required';
        isValid = false;
    }

    if (!isValid) return;

    // Create form data for multipart request
    const formData = new FormData();
    formData.append('book', new Blob([JSON.stringify(bookData)], { type: "application/json" }));
    formData.append('file', file);
    formData.append('coverImage', coverImage);

    try {
        const response = await fetch('/api/books/upload', {
            method: 'POST',
            body: formData
        });

        if (response.ok) {
            const result = await response.json();
            debugger;
            alert(`Book uploaded successfully! ID: ${result.data.bookId}`);
            console.log('Book uploaded:', result);
        } else {
            const error = await response.json();
            alert(`Upload failed: ${error.message}`);
            console.error('Error:', error);
        }
    } catch (error) {
        alert('An error occurred while uploading.');
        console.error('Error:', error);
    }
};
