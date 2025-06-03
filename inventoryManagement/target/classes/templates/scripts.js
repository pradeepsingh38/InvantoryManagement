fetch('http://localhost:8080/api/items')
  .then(response => response.json())
  .then(data => {
    const itemList = document.getElementById('item-list');
    data.forEach(item => {
      const li = document.createElement('li');
      li.textContent = `${item.name} - ₹${item.price}`;
      itemList.appendChild(li);
    });
  });