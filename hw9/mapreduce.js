var o = {
  				map: function() {			
						g = this;

						if( this.all_members )
						{
							this.all_members.forEach( function( netID ) {
								emit( netID, g.slug );
							} );	
						}

					},
					reduce: function( key, values ) {
						return {
							groups: values
						};
					},
					finalize: function( key, values ) {
						if( typeof values == "string" )
						{
							return {
								groups: [ values ]
							}
						}
						else
						{
							return values;
						}
					},
					out: { replace: 'user_groups' }
				};

				Group.mapReduce(o, function (err, results) {		
					if( err )
					{
						console.log( err );
					}
				});
