/* Note: New tables at bottom of file, Insert statements for new Items under item table */

/* create Item table*/
CREATE TABLE Item(
bid VARCHAR(20) NOT NULL PRIMARY KEY,
name VARCHAR(60) NOT NULL,
description VARCHAR(2000) NOT NULL,
type VARCHAR(60) NOT NULL,
brand VARCHAR(60) NOT NULL,
quantity INT NOT NULL,
price INT NOT NULL
);

/*insert data into item table*/
INSERT INTO Item (bid, name, description, type, brand, price, quantity) VALUES ('b001', 'Iphone 12', 'Let the fun begin with the iPhone 12. It features the powerful A14 Bionic chip, 5G to download and stream high-quality video, a bright 6.1" Super Retina XDR display, and Ceramic Shield for better drop performance. Other features include incredible low-light photography with Night mode on both cameras, cinema-grade Dolby Vision, new MagSafe accessories for wireless charging, and much more.', 'phone', 'apple', 900, 100, "images/iphone12.jpeg");
INSERT INTO Item (bid, name, description, type, brand, price, quantity) VALUES ('c001', 'iPad', 'a device for personal use', 'phone', 'apple', 500, 100, "images/ipad.jpg");
INSERT INTO Item (bid, name, description, type, brand, price, quantity) VALUES ('d001', 'macbook', 'a device for personal use', 'laptop', 'apple', 1500, 100, "images/macbook.jpg");
INSERT INTO Item (bid, name, description, type, brand, price, quantity, img) VALUES ('e001', 'Iphone 14 pro', 'Experience iPhone in a whole new way with the iPhone 14 Pro. Enjoy peace of mind with groundbreaking emergency features that keep you safe and capture incredible detail in images and videos with the 48MP main camera. The Always-On display and Dynamic Island features help you interact with your phone more intuitively than before.', 'phone', 'apple', 1500, 100, "images/iphone14pro.jpeg");
INSERT INTO Item (bid, name, description, type, brand, price, quantity, img) VALUES ('f001', 'Iphone 13', 'Stand out and show-off your superpowers with the iPhone 13. It features the powerful A15 Bionic chip, superfast 5G to download and stream high-quality video, a bright 6.1" Super Retina XDR display, and Ceramic Shield for better drop performance. Other features include 4K Dolby Vision HDR recording, an advanced dual-camera system with Night mode, extra-ordinary battery life, and much more.', 'phone', 'apple', 1100, 100, "images/iphone13.jpeg");
INSERT INTO Item (bid, name, description, type, brand, price, quantity, img) VALUES ('g001', 'Iphone Se', 'The powerful 4.7-inch iPhone SE (2nd Generation) features the A13 Bionic chip and 64GB of storage for incredible performance in apps, games, and photography. It has portrait mode for studio-quality portraits, 6 lighting effects, Smart HDR, and cinematic-quality 4K video. With a long battery life and water resistance, it’s the iPhone you love in a not-so-big size.', 'phone', 'apple', 600, 100, "images/iphonese.jpeg");
INSERT INTO Item (bid, name, description, type, brand, price, quantity, img) VALUES ('h001', 'Macbook Air', 'Apple’s thinnest and lightest notebook gets supercharged with the Apple M1 chip. Tackle your projects with the blazing-fast 8-core CPU. Take graphics-intensive apps and games to the next level with a 7-core GPU. Accelerate machine-learning tasks with the 16-core Neural Engine. All with a silent, fanless design and the longest battery life ever -- up to 18 hours.', 'laptop', 'apple', 1400, 100, "images/macbookair.png");
INSERT INTO Item (bid, name, description, type, brand, price, quantity, img) VALUES ('i001', 'Macbook pro', 'The first notebook of its kind, this Apple MacBook Pro is a beast. With the blazing-fast M1 Pro chip — the first Apple silicon designed for pros — you get groundbreaking performance and amazing battery life. Add to that a stunning Liquid Retina XDR display, the best camera and audio ever in a Mac notebook, and all the ports you need.', 'laptop', 'apple', 2000, 100, "images/macbookpro.png");
INSERT INTO Item (bid, name, description, type, brand, price, quantity, img) VALUES ('j001', 'Galaxy flip', 'Small but powerful the Galaxy Z Flip4 fits everything you need in one compact-sized smartphone. It features an ultra thin foldable full screen display that allows you to do more in one screen. Catch up with friends on the top screen while find a post-worthy selfie on the bottom. Plus, it boasts the Flexcam feature that lets you take selfies hands-free so youre sure everybodys in the frame.', 'phone', 'samsung', 1800, 100, "images/galaxyflip.jpg");
INSERT INTO Item (bid, name, description, type, brand, price, quantity, img) VALUES ('k001', 'Galaxy fold', 'Enjoy innovative flexibility anywhere with the Samsung Galaxy Z Fold4 5G smartphone. This unique device unfolds into a tablet and enables hands-free viewing so you can effortlessly go from pocket to table. Complete multiple tasks at once with the Multi-Window feature, and play games and stream videos seamlessly with its vibrant display and sturdy, water-resistant build.', 'phone', 'samsung', 1700, 100, "images/galaxyfold.jpg");
INSERT INTO Item (bid, name, description, type, brand, price, quantity, img) VALUES ('l001', 'Samsung Galaxy S22', 'Redefine the way you work and collaborate with the Samsung Galaxy S22 5G smartphone. It boasts a smooth and adaptive 120Hz display with intelligent blue light management, 8K video, and 50MP photo resolution that let you create professional quality content on the go. It features the Night Mode for crystal-clear nightography, co-watching with Google Duo, and all-day battery to accomplish more.', 'phone', 'samsung', 1000, 100, "images/s22.jpg");
INSERT INTO Item (bid, name, description, type, brand, price, quantity, img) VALUES ('m001', 'Samsung book go', 'Stay efficient and productive wherever you go with the power of this Samsung Galaxy Book Go laptop. Thin and shockproof, it travels well without sacrificing on performance. It’s packed with a Qualcomm Snapdragon 7c octa-core processor, 4GB of RAM, and a speedy 128GB solid state drive so it has the power you need to handle any task.', 'laptop', 'samsung', 700, 100, "images/go.jpg");
INSERT INTO Item (bid, name, description, type, brand, price, quantity, img) VALUES ('n001', 'Samsung Chromebook', 'Google Classroom Compatible! The quality of Samsung meets the accessibility of Chrome OS. Its all-new light and compact design lets you stream, work, create, and play on a fast, secure device designed to take everywhere. This item was manufactured in 2020. Compact, light design with ultra-fast connectivity of Gigabit WiFi. Extremely well 12.5" hours of battery life. Latest Model.', 'laptop', 'samsung', 300, 100, "images/chromebook.jpeg");




/*create an addtess table*/
CREATE TABLE Address (
id INT NOT NULL,
street VARCHAR(100) NOT NULL,
province VARCHAR(20) NOT NULL,
country VARCHAR(20) NOT NULL,
zip VARCHAR(20) NOT NULL,
phone VARCHAR(20),
PRIMARY KEY(id)
);
/*populate the address table*/
INSERT INTO Address (id, street, province, country, zip, phone) VALUES (1, '123 Yonge St', 'ON', 'Canada', 'K1E 6T5' ,'647-123-4567');
INSERT INTO Address (id, street, province, country, zip, phone) VALUES (2, '445 Avenue rd', 'ON', 'Canada', 'M1C 6K5' ,'416-123-8569');
INSERT INTO Address (id, street, province, country, zip, phone) VALUES (3, '789 Keele St.', 'ON', 'Canada', 'K3C 9T5' ,'416-123-9568');
/* create Purchase Order(PO) table */
/* Purchase Order
* lname: last name
* fname:
* id:
first name
purchase order id
* status: status of purchase: Processed, Denied, Ordered
*/
CREATE TABLE PO (
id INT NOT NULL,
lname VARCHAR(20) NOT NULL,
fname VARCHAR(20) NOT NULL,
status VARCHAR(20)NOT NULL,
address INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (address) REFERENCES Address (id)
);
/*
* Inserting data for table
'PO' */
INSERT INTO PO (id, lname, fname, status, address) VALUES (1, 'John', 'White', 'PROCESSED', 1);
INSERT INTO PO (id, lname, fname, status, address) VALUES (2, 'Peter', 'Black', 'DENIED', 2);
INSERT INTO PO (id, lname, fname, status, address) VALUES (3, 'Andy', 'Green', 'ORDERED', 3);
/*create table Purchase Ordert Item, contains items on each order*/
CREATE TABLE POItem (
id INT NOT NULL,
bid VARCHAR(20) NOT NULL,
price INT NOT NULL,
PRIMARY KEY(id,bid),
FOREIGN KEY(id) REFERENCES PO(id),
FOREIGN KEY(bid) REFERENCES Item(bid)
);
/*
*Inserting data for table 'POitem'
*/
INSERT INTO POItem (id, bid, price) VALUES (1, 'b001', 20);
INSERT INTO POItem (id, bid, price) VALUES (2, 'c001', 500);
/* visit to website
* ipaddress: varchar
* day: date
* bid: unique identifier of item
* eventtype: status of purchase
*/
CREATE TABLE VisitEvent (
ipaddress varchar (20) NOT NULL,
day varchar(8) NOT NULL,
bid varchar(20) not null,
eventtype varchar(20) NOT NULL,
FOREIGN KEY(bid) REFERENCES Item(bid)
);
/*
* data for table 'VisitEvent'
*/
INSERT INTO VisitEvent (ipaddress, day, bid, eventtype) VALUES ('1.23.4.5','12202022', 'b001', 'VIEW');
INSERT INTO VisitEvent (ipaddress, day, bid, eventtype) VALUES ('1.23.4.5', '12242022','b001', 'CART');
INSERT INTO VisitEvent (ipaddress,day, bid, eventtype) VALUES ('1.23.4.5', '12252022', 'b001', 'PURCHASE');

/* add img attribute for item table */
ALTER TABLE Item ADD img VARCHAR(60);
/*
* data for table 'User'
*/
CREATE TABLE User(
	username VARCHAR(60) NOT NULL,
	password VARCHAR(60) NOT NULL,
	fname VARCHAR(20) NOT NULL,
	lname VARCHAR(20) NOT NULL,
	address INT NOT NULL,
	email VARCHAR(60) NOT NULL,
    PRIMARY KEY(username),
	FOREIGN KEY (address) REFERENCES Address (id)
);
/*
* data for table 'Review'
*/
Create TABLE Review(
	username VARCHAR(60) NOT NULL,
	review VARCHAR(120) NOT NULL,
    rating INT NOT NULL,
    bid VARCHAR(20) NOT NULL,
	FOREIGN KEY(bid) REFERENCES Item(bid)
);