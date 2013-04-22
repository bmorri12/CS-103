This is a simple map/reduce program I implemented for an authentication system.

In a [MongoDB database](http://docs.mongodb.org/manual/core/map-reduce/), we have a collection called groups with a property called all_members, which contains an array of the IDs of every member in the group.

We want to create a new collection called user_groups which contains the groups each user is in, indexed by their user ID.

This Map/Reduce program generates that new table by:

1. Map: iterating through every member of every group, emiting one call each time. (So, a group with 20 members emits 20 times.)
2. Reduce: combine multiple emissions (ie. a user in multiple groups) into a single entry
3. Finalize: standardize the object, primarily for cases where a user is only in one group (and hence reduce was never called).
