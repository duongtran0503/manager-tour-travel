CREATE TABLE `users` (
  `user_id` varchar(255) PRIMARY KEY,
  `name` varchar(255),
  `password` varchar(255),
  `email` varchar(255),
  `address` varchar(255),
  `status` int,
  `roleId` varchar(255),
  `account_authorize` int,
  `phone_number` varchar(255),
  `description` varchar(255),
  `create_at` datetime,
  `update_at` datetime
);

CREATE TABLE `roles` (
  `roleId` varchar(255) PRIMARY KEY,
  `role` varchar(255)
);

CREATE TABLE `tours` (
  `tour_id` varchar(255),
  `title` varchar(255),
  `price_one_person` varchar(255),
  `image_id` varchar(255),
  `destination_description` varchar(255),
  `address` varchar(255),
  `time_book_start` varchar(255),
  `time_slot_length` varchar(255),
  `time_book_end` varchar(255),
  `rating` float(1),
  `totail_rating` int,
  `totail_start` iht,
  `seoTile` varchar(255),
  `create_by` varchar(255),
  `create_at` datetime,
  `update_at` datetime
);

CREATE TABLE `images` (
  `iamge_id` varchar(255) PRIMARY KEY,
  `image_main` varchar(255),
  `sub_image` varchar(255)
);

CREATE TABLE `ratings` (
  `rating_id` int PRIMARY KEY,
  `comment_id` varchar(255),
  `tuor_id` varchar(255),
  `detail` varchar(255),
  `user_id` varchar(255),
  `create_at` datetime,
  `update_at` datetime
);

CREATE TABLE `comments` (
  `comment_id` varchar(255) PRIMARY KEY,
  `tuor_id` varchar(255),
  `detail` varchar(255),
  `user_id` varchar(255),
  `create_at` datetime,
  `update_at` datetime
);

CREATE TABLE `time_book_details` (
  `time_id` varchar(255),
  `tuor_id` varchar(255),
  `start_time` varchar(255),
  `end_time` varchar(255),
  `is_payment` varchar(255),
  `is_deleted` varchar(255),
  `create_at` datetime,
  `update_at` datetime
);

ALTER TABLE `users` ADD FOREIGN KEY (`roleId`) REFERENCES `roles` (`roleId`);

ALTER TABLE `tours` ADD FOREIGN KEY (`image_id`) REFERENCES `images` (`iamge_id`);

ALTER TABLE `ratings` ADD FOREIGN KEY (`comment_id`) REFERENCES `comments` (`comment_id`);

ALTER TABLE `ratings` ADD FOREIGN KEY (`tuor_id`) REFERENCES `tours` (`tour_id`);

ALTER TABLE `ratings` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `comments` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `time_book_details` ADD FOREIGN KEY (`tuor_id`) REFERENCES `tours` (`tour_id`);
