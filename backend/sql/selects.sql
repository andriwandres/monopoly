---- Select all properties
SELECT property_id,
       board_id,
       property_position_index,
       property_name,
       property_type,
       property_color_group,
       property_price,
       property_mortgage_value,
       property_house_cost,
       property_hotel_cost,
       property_rent_base,
       property_rent_all_properties,
       property_rent_with_one_house,
       property_rent_with_two_houses,
       property_rent_with_three_houses,
       property_rent_with_four_houses,
       property_rent_with_hotel
FROM properties
ORDER BY property_id, board_id, property_position_index;