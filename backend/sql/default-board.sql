INSERT INTO boards (board_id, board_name, board_description)
VALUES (1, 'Swiss Cities Monopoly', 'A Monopoly board featuring common Swiss cities');

-- Start Field
INSERT INTO properties (property_id, property_position_index, property_name, property_type, board_id)
VALUES (1, 0, 'Start', 'START', 1);

-- Brown Properties
INSERT INTO properties (property_id, property_position_index, property_name, property_type, property_color_group, property_price, property_rent_base, property_house_cost, property_hotel_cost, property_mortgage_value, property_rent_with_one_house, property_rent_with_two_houses, property_rent_with_three_houses, property_rent_with_four_houses, property_rent_with_hotel, board_id)
VALUES
    (2, 1, 'Chur', 'PROPERTY', 'Brown', 60, 2, 50, 50, 30, 10, 30, 90, 160, 250, 1),
    (3, 3, 'Sion', 'PROPERTY', 'Brown', 60, 4, 50, 50, 30, 20, 60, 180, 320, 450, 1);

-- Community Chest
INSERT INTO properties (property_id, property_position_index, property_name, property_type, board_id)
VALUES (4, 2, 'Community Chest', 'TREASURE', 1);

-- Income Tax
INSERT INTO properties (property_id, property_position_index, property_name, property_type, board_id)
VALUES (5, 4, 'Income Tax', 'TAX', 1);

-- Airports (Railroads)
INSERT INTO properties (property_id, property_position_index, property_name, property_type, property_price, property_mortgage_value, board_id)
VALUES
    (6, 5, 'Zurich Airport', 'AIRPORT', 200, 100, 1),
    (16, 15, 'Geneva Airport', 'AIRPORT', 200, 100, 1),
    (26, 25, 'Basel Airport', 'AIRPORT', 200, 100, 1),
    (36, 35, 'Bern Airport', 'AIRPORT', 200, 100, 1);

-- Light Blue Properties
INSERT INTO properties (property_id, property_position_index, property_name, property_type, property_color_group, property_price, property_rent_base, property_house_cost, property_hotel_cost, property_mortgage_value, property_rent_with_one_house, property_rent_with_two_houses, property_rent_with_three_houses, property_rent_with_four_houses, property_rent_with_hotel, board_id)
VALUES
    (7, 6, 'Neuchâtel', 'PROPERTY', 'Light Blue', 100, 6, 50, 50, 50, 30, 90, 270, 400, 550, 1),
    (9, 8, 'Schaffhausen', 'PROPERTY', 'Light Blue', 100, 6, 50, 50, 50, 30, 90, 270, 400, 550, 1),
    (10, 9, 'Fribourg', 'PROPERTY', 'Light Blue', 120, 8, 50, 50, 60, 40, 100, 300, 450, 600, 1);

-- Chance
INSERT INTO properties (property_id, property_position_index, property_name, property_type, board_id)
VALUES (8, 7, 'Chance', 'SURPRISE', 1);

-- Jail
INSERT INTO properties (property_id, property_position_index, property_name, property_type, board_id)
VALUES (11, 10, 'Jail', 'JAIL', 1);

-- Pink Properties
INSERT INTO properties (property_id, property_position_index, property_name, property_type, property_color_group, property_price, property_rent_base, property_house_cost, property_hotel_cost, property_mortgage_value, property_rent_with_one_house, property_rent_with_two_houses, property_rent_with_three_houses, property_rent_with_four_houses, property_rent_with_hotel, board_id)
VALUES
    (12, 11, 'Biel/Bienne', 'PROPERTY', 'Pink', 140, 10, 100, 100, 70, 50, 150, 450, 625, 750, 1),
    (14, 13, 'Thun', 'PROPERTY', 'Pink', 140, 10, 100, 100, 70, 50, 150, 450, 625, 750, 1),
    (15, 14, 'La Chaux-de-Fonds', 'PROPERTY', 'Pink', 160, 12, 100, 100, 80, 60, 180, 500, 700, 900, 1);

-- Swiss Electric Company (Utility)
INSERT INTO properties (property_id, property_position_index, property_name, property_type, property_price, property_mortgage_value, board_id)
VALUES (13, 12, 'Swiss Electric Company', 'COMPANY', 150, 75, 1);

-- Orange Properties
INSERT INTO properties (property_id, property_position_index, property_name, property_type, property_color_group, property_price, property_rent_base, property_house_cost, property_hotel_cost, property_mortgage_value, property_rent_with_one_house, property_rent_with_two_houses, property_rent_with_three_houses, property_rent_with_four_houses, property_rent_with_hotel, board_id)
VALUES
    (17, 16, 'Köniz', 'PROPERTY', 'Orange', 180, 14, 100, 100, 90, 70, 200, 550, 750, 950, 1),
    (19, 18, 'Vernier', 'PROPERTY', 'Orange', 180, 14, 100, 100, 90, 70, 200, 550, 750, 950, 1),
    (20, 19, 'Lugano', 'PROPERTY', 'Orange', 200, 16, 100, 100, 100, 80, 220, 600, 800, 1000, 1);

-- Community Chest
INSERT INTO properties (property_id, property_position_index, property_name, property_type, board_id)
VALUES (18, 17, 'Community Chest', 'TREASURE', 1);

-- Free Parking
INSERT INTO properties (property_id, property_position_index, property_name, property_type, board_id)
VALUES (21, 20, 'Free Parking', 'VACATION', 1);

-- Red Properties
INSERT INTO properties (property_id, property_position_index, property_name, property_type, property_color_group, property_price, property_rent_base, property_house_cost, property_hotel_cost, property_mortgage_value, property_rent_with_one_house, property_rent_with_two_houses, property_rent_with_three_houses, property_rent_with_four_houses, property_rent_with_hotel, board_id)
VALUES
    (22, 21, 'St. Gallen', 'PROPERTY', 'Red', 220, 18, 150, 150, 110, 90, 250, 700, 875, 1050, 1),
    (24, 23, 'Winterthur', 'PROPERTY', 'Red', 220, 18, 150, 150, 110, 90, 250, 700, 875, 1050, 1),
    (25, 24, 'Lucerne', 'PROPERTY', 'Red', 240, 20, 150, 150, 120, 100, 300, 750, 925, 1100, 1);

-- Chance
INSERT INTO properties (property_id, property_position_index, property_name, property_type, board_id)
VALUES (23, 22, 'Chance', 'SURPRISE', 1);

-- Swiss Water Works (Utility)
INSERT INTO properties (property_id, property_position_index, property_name, property_type, property_price, property_mortgage_value, board_id)
VALUES (29, 28, 'Swiss Water Works', 'COMPANY', 150, 75, 1);

-- Yellow Properties
INSERT INTO properties (property_id, property_position_index, property_name, property_type, property_color_group, property_price, property_rent_base, property_house_cost, property_hotel_cost, property_mortgage_value, property_rent_with_one_house, property_rent_with_two_houses, property_rent_with_three_houses, property_rent_with_four_houses, property_rent_with_hotel, board_id)
VALUES
    (27, 26, 'St. Gallen', 'PROPERTY', 'Yellow', 260, 22, 150, 150, 130, 110, 330, 800, 975, 1150, 1),
    (28, 27, 'Winterthur', 'PROPERTY', 'Yellow', 260, 22, 150, 150, 130, 110, 330, 800, 975, 1150, 1),
    (30, 29, 'Lucerne', 'PROPERTY', 'Yellow', 280, 24, 150, 150, 140, 120, 360, 850, 1025, 1200, 1);

-- Go To Jail
INSERT INTO properties (property_id, property_position_index, property_name, property_type, board_id)
VALUES (31, 30, 'Go To Jail', 'GO_TO_JAIL', 1);

-- Green Properties
INSERT INTO properties (property_id, property_position_index, property_name, property_type, property_color_group, property_price, property_rent_base, property_house_cost, property_hotel_cost, property_mortgage_value, property_rent_with_one_house, property_rent_with_two_houses, property_rent_with_three_houses, property_rent_with_four_houses, property_rent_with_hotel, board_id)
VALUES
    (32, 31, 'Bern', 'PROPERTY', 'Green', 300, 26, 200, 200, 150, 130, 390, 900, 1100, 1275, 1),
    (33, 32, 'Basel', 'PROPERTY', 'Green', 300, 26, 200, 200, 150, 130, 390, 900, 1100, 1275, 1),
    (35, 34, 'Lausanne', 'PROPERTY', 'Green', 320, 28, 200, 200, 160, 150, 450, 1000, 1200, 1400, 1);

-- Community Chest
INSERT INTO properties (property_id, property_position_index, property_name, property_type, board_id)
VALUES (34, 33, 'Community Chest', 'TREASURE', 1);

-- Chance
INSERT INTO properties (property_id, property_position_index, property_name, property_type, board_id)
VALUES (37, 36, 'Chance', 'SURPRISE', 1);

-- Dark Blue Properties
INSERT INTO properties (property_id, property_position_index, property_name, property_type, property_color_group, property_price, property_rent_base, property_house_cost, property_hotel_cost, property_mortgage_value, property_rent_with_one_house, property_rent_with_two_houses, property_rent_with_three_houses, property_rent_with_four_houses, property_rent_with_hotel, board_id)
VALUES
    (38, 37, 'Geneva', 'PROPERTY', 'Dark Blue', 350, 35, 200, 200, 175, 175, 500, 1100, 1300, 1500, 1),
    (40, 39, 'Zurich', 'PROPERTY', 'Dark Blue', 400, 50, 200, 200, 200, 200, 600, 1400, 1700, 2000, 1);

-- Luxury Tax
INSERT INTO properties (property_id, property_position_index, property_name, property_type, board_id)
VALUES (39, 38, 'Luxury Tax', 'TAX', 1);
